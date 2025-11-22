import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Cursos() {
  const [cursos, setCursos] = useState([]);
  const [nome, setNome] = useState("");
  const [cargaHoraria, setCargaHoraria] = useState("");
  const [erro, setErro] = useState(null);

  const navigate = useNavigate();
  const API_URL = "http://localhost:8080/api/cursos"; // Ajuste se o endpoint for diferente

  const fetchCursos = () => {
    fetch(API_URL)
      .then(response => {
        if (!response.ok) throw new Error("Erro ao acessar API");
        return response.json();
      })
      .then(data => setCursos(data))
      .catch(err => setErro("Erro ao conectar no backend: " + err.message));
  };

  useEffect(() => {
    fetchCursos();
  }, []);

  const adicionarCurso = (e) => {
    e.preventDefault();

    fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nome, cargaHoraria: parseInt(cargaHoraria) })
    })
      .then(response => {
        if (!response.ok) throw new Error("Erro ao adicionar curso");
        return response.json();
      })
      .then(() => {
        setNome("");
        setCargaHoraria("");
        fetchCursos();
      })
      .catch(err => setErro("Erro ao adicionar curso: " + err.message));
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <button onClick={() => navigate("/")}>⬅ Voltar ao Dashboard</button>

      <h1>📚 Gestão de Cursos</h1>

      {erro && <p style={{ color: "red" }}>{erro}</p>}

      <h2>Adicionar Curso</h2>
      <form onSubmit={adicionarCurso}>
        <input
          type="text"
          placeholder="Nome do Curso"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
          required
        />
        <input
          type="number"
          placeholder="Carga Horária"
          value={cargaHoraria}
          onChange={(e) => setCargaHoraria(e.target.value)}
          required
        />
        <button type="submit">Adicionar Curso</button>
      </form>

      <h2>Lista de Cursos</h2>
      {cursos.length === 0 && <p>Nenhum curso encontrado...</p>}
      <ul>
        {cursos.map(curso => (
          <li key={curso.id}>
            {curso.nome} - {curso.cargaHoraria} horas
          </li>
        ))}
      </ul>
    </div>
  );
}
