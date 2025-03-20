import React from "react";
import { useErrors } from "../hooks/useErrors"; // Asegúrate que el path sea el correcto

const ErrorTable: React.FC = () => {
  const { errors, loading, errorMessage } = useErrors();

  if (loading) {
    return <p className="text-buffy text-center">Cargando la tabla de errores...</p>;
  }

  if (errorMessage) {
    return <p className="text-marcelin-400 text-center">Error: {errorMessage}</p>;
  }

  return (
    <div className="bg-aro-100 min-h-screen p-4 flex flex-col justify-center items-center">
      {/* Título separado de la tabla */}
      <h2 className="text-3xl font-bold mb-6 text-buffy-500 text-center">Tabla de Errores</h2>

      {/* Contenedor de la tabla */}
      <div className="overflow-x-auto w-full max-w-5xl bg-light-50 border-neutral-950 rounded-lg shadow-lg">
        <table className="min-w-full table-auto border-collapse border border-nosferatu mx-auto">
          <thead className="bg-vonCount-500 text-light-50">
            <tr>
              <th className="border border-nosferatu px-6 py-3 text-center font-semibold">Tipo</th>
              <th className="border border-nosferatu px-6 py-3 text-center font-semibold">Descripción</th>
              <th className="border border-nosferatu px-6 py-3 text-center font-semibold">Línea</th>
              <th className="border border-nosferatu px-6 py-3 text-center font-semibold">Columna</th>
            </tr>
          </thead>
          <tbody>
            {errors.length > 0 ? (
              errors.map((error, index) => (
                <tr
                  key={index}
                  className="hover:bg-dracula-700 hover:text-light transition-all duration-300 ease-in-out"
                >
                  <td className="border border-nosferatu px-4 py-2 text-center">{error.type}</td>
                  <td className="border border-nosferatu px-4 py-2 text-center">{error.description}</td>
                  <td className="border border-nosferatu px-4 py-2 text-center">{error.line}</td>
                  <td className="border border-nosferatu px-4 py-2 text-center">{error.column}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td
                  colSpan={4}
                  className="text-center py-4 bg-nosferatu-50 text-buffy-800"
                >
                  No se encontraron errores
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ErrorTable;
