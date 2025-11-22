import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import Alunos from "./pages/Alunos";
import Cursos from "./pages/Cursos"; 

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/alunos" element={<Alunos />} />
        <Route path="/cursos" element={<Cursos />} />
      </Routes>
    </BrowserRouter>
  );
}
