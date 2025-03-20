import { useState, useEffect } from "react";

export const useDotCode = () => {
  const [dotCode, setDotCode] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  useEffect(() => {
    const fetchDotCode = async () => {
      setLoading(true);
      try {
        const response = await fetch("http://localhost:5011/compile/generateDot"); 
        if (!response.ok) {
          throw new Error("Error al obtener el código DOT.");
        }
        const data = await response.text(); 
        console.log("Respuesta del servidor:");
        console.log(data); 
        setDotCode(data);  
      } catch (error) {
        if (error instanceof Error) {
          setErrorMessage(error.message); 
        } else {
          setErrorMessage("Error desconocido.");
        }
      } finally {
        setLoading(false); 
      }
    };
  
    fetchDotCode(); // Ejecutar una vez al montar el componente
  }, []);
  
  return { dotCode, loading, errorMessage };
};
