import React, { useRef, useState, useEffect } from "react";
import { Graphviz } from "graphviz-react";
import { useDotCode } from "../hooks/useGenerateDot";
import { saveAs } from "file-saver";

const DotGraph: React.FC = () => {
  const { dotCode, loading, errorMessage } = useDotCode();
  const graphRef = useRef<HTMLDivElement | null>(null);
  const [zoomLevel, setZoomLevel] = useState(1);

  // Incrementar o disminuir el zoom (con factor dinámico)
  const handleZoom = (factor: number) => {
    setZoomLevel((prevZoom) => {
      const newZoom = Math.min(Math.max(prevZoom * factor, 0.1), 20); // Mayor rango (hasta 20x)
      return newZoom;
    });
  };

  // Descargar el SVG directamente
  const handleDownloadSVG = () => {
    if (graphRef.current) {
      const svgElement = graphRef.current.querySelector("svg");
      if (svgElement) {
        const svgString = new XMLSerializer().serializeToString(svgElement);
        const blob = new Blob([svgString], { type: "image/svg+xml;charset=utf-8" });
        saveAs(blob, "graph.svg");
      }
    }
  };

  useEffect(() => {
    const container = graphRef.current;
    if (!container) return;

    const handleWheel = (event: WheelEvent) => {
      if (event.ctrlKey || event.metaKey) {
        event.preventDefault();
        const direction = event.deltaY > 0 ? 0.9 : 1.1;
        handleZoom(direction);
      }
    };

    container.addEventListener("wheel", handleWheel, { passive: false });
    return () => container.removeEventListener("wheel", handleWheel);
  }, []);

  if (loading) return <p>Cargando gráfico...</p>;
  if (errorMessage) return <p>Error: {errorMessage}</p>;

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100 p-4">
      {/* Botón de descarga */}
      <button
        onClick={handleDownloadSVG}
        className="mb-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
      >
        Descargar SVG
      </button>

      {/* Contenedor del gráfico */}
      <div
        ref={graphRef}
        className="overflow-auto border rounded bg-white shadow flex justify-center items-center"
        style={{
          width: "100%",
          height: "80vh",
        }}
      >
        {/* Contenedor escalable */}
        <div
          style={{
            transform: `scale(${zoomLevel})`,
            transformOrigin: "center center", // Centrado de zoom
            transition: "transform 0.1s ease-in-out", // Suaviza el zoom
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          {dotCode ? (
            <Graphviz
              dot={dotCode}
              options={{
                height: 1280,
                width: 1920,
                fit: true,
                zoom: true, // esto es interno de graphviz-react
                engine: "dot", // opcional, puedes probar otros layouts
              }}
            />
          ) : (
            <p>No hay código DOT disponible.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default DotGraph;
