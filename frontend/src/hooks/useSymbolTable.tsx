import { useState, useEffect } from "react";

// Actualizamos la interfaz para que coincida con la respuesta del backend
interface Symbol {
    id: string;
    type: string;
    dataType: string;
    scope: string;
    value: string; 
    line: number;
    column: number;
}
function useSymbolTable() {
    const [symbols, setSymbols] = useState<Symbol[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchSymbols = async () => {
            setLoading(true);
            try {
                const response = await fetch("http://localhost:5011/compile/symbols");
                if (!response.ok) {
                    throw new Error("Error al obtener la tabla de símbolos");
                }
                const data = await response.json();
                setSymbols(data);
            } catch (err) {
                if (err instanceof Error) {
                    setError(err.message);
                }
            } finally {
                setLoading(false);
            }
        };

        fetchSymbols();
    }, []);

    return { symbols, loading, error };
}

export default useSymbolTable;
