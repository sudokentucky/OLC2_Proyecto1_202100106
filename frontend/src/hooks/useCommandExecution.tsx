import { useState, useCallback } from "react";

function useCommandExecution() {
  const [inputText, setInputText] = useState(""); // Código fuente a compilar
  const [outputText, setOutputText] = useState(""); // Resultado de la compilación
  const [loading, setLoading] = useState(false); // Estado de carga
  const [message, setMessage] = useState(""); // Mensajes de estado
  const [messageType, setMessageType] = useState<"success" | "error" | "info" | "">("");

  // Función para mostrar mensajes temporales
  const showMessage = useCallback((text: string, type: "success" | "error" | "info") => {
    setMessage(text);
    setMessageType(type);
    setTimeout(() => {
      setMessage("");
      setMessageType("");
    }, 5000);
  }, []);

  // Función para enviar el código al backend y compilarlo
  const handleExecute = useCallback(async () => {
    if (!inputText.trim()) {
      showMessage("El área de texto está vacía. Por favor, ingrese un comando o cargue un archivo.", "error");
      return;
    }

    setLoading(true);
    try {
      // Se envía el código en formato JSON al endpoint /Compile
      const response = await fetch("http://localhost:5011/compile", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ code: inputText })
      });

      const data = await response.json();

      if (!response.ok) {
        // Se asume que en caso de error el controller devuelve { error: "mensaje" }
        setOutputText(data.error || "Error en la compilación.");
        showMessage("Se encontraron errores en la ejecución.", "error");
        return;
      }

      // En caso de éxito, se muestra la salida del compilador
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

  // Función para resetear los campos de entrada y salida
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
