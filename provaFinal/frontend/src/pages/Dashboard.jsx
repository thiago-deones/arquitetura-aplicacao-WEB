import React from "react";
import { Link } from "react-router-dom";

function Dashboard() {
  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>🏠 Dashboard</h1>
      <p>Escolha uma opção:</p>
      <ul>
        <li><Link to="/alunos">Gerenciar Alunos</Link></li>
        <li><Link to="/cursos">Gerenciar Cursos</Link></li>
      </ul>
    </div>
  );
}

export default Dashboard;
