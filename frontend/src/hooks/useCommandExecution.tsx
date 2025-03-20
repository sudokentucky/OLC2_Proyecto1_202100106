import { useState, useCallback } from "react";

function useCommandExecution() {
  const [inputText, setInputText] = useState(""); // Código fuente a compilar
  const [outputText, setOutputText] = useState(""); // Resultado o errores detallados
  const [loading, setLoading] = useState(false); // Estado de carga
  const [message, setMessage] = useState(""); // Mensaje breve de estado
  const [messageType, setMessageType] = useState<"success" | "error" | "info" | "">("");

  // Mensaje breve arriba del editor
  const showMessage = useCallback((text: string, type: "success" | "error" | "info") => {
    setMessage(text);
    setMessageType(type);
    setTimeout(() => {
      setMessage("");
      setMessageType("");
    }, 5000);
  }, []);

  // Ejecuta el código enviándolo al backend
  const handleExecute = useCallback(async () => {
    if (!inputText.trim()) {
      showMessage(
        "El área de texto está vacía. Por favor, ingrese un comando o cargue un archivo.",
        "error"
      );
      return;
    }

    setLoading(true);

    try {
      const response = await fetch("http://localhost:5011/compile", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ code: inputText })
      });

      const data = await response.json();

      if (!response.ok) {
        // Mensaje general que ya devuelve el backend
        const generalError = data.error || "Errores encontrados durante la compilación.";
        showMessage(generalError, "error");

        // Si hay lista de errores, los mostramos en consola y en el outputText
        if (data.errors && Array.isArray(data.errors)) {
          const errorDetails = data.errors.join("\n");

          // Mostrarlos en consola para depuración
          console.error("Errores detallados:", errorDetails);

          // Mostrar en el área de salida
          setOutputText(`Errores encontrados durante la compilación:\n\n${errorDetails}`);
        } else {
          // Si no vienen los errores detallados
          setOutputText(generalError);
        }

        return;
      }

      // Éxito
      setOutputText(data.result);
      showMessage("Ejecución completada con éxito", "success");

    } catch (error) {
      if (error instanceof Error) {
        setOutputText(`Error: ${error.message}`);
        showMessage(`Error en la ejecución: ${error.message}`, "error");
      } else {
        setOutputText("Error desconocido");
        showMessage("Error en la ejecución: Error desconocido", "error");
      }

    } finally {
      setLoading(false);
    }
  }, [inputText, showMessage]);

  // Resetea los campos
  const handleReset = useCallback(() => {
    setInputText("");
    setOutputText("");
    showMessage("Campos limpiados correctamente", "info");
  }, [showMessage]);

  return {
    inputText,
    setInputText,
    outputText,
    loading,
    message,
    messageType,
    handleExecute,
    handleReset
  };
}

export default useCommandExecution;
