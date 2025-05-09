import { useState, useEffect } from "react";

interface Error {
  type: string;
  line: number;
  column: number;
  description: string;
}

export const useErrors = () => {
  const [errors, setErrors] = useState<Error[]>([]);
  const [loading, setLoading] = useState(false);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  useEffect(() => {
    const fetchErrors = async () => {
      setLoading(true);
      try {
        const response = await fetch("http://localhost:5011/compile/errors");
        if (!response.ok) {
          throw new Error("Error al obtener la lista de errores.");
        }
        const data = await response.json();
        setErrors(data);
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

    fetchErrors();
  }, []); // El hook se ejecuta una sola vez al montar el componente.

  return { errors, loading, errorMessage };
};
