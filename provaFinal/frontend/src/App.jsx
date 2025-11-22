import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Alunos() {
  const [alunos, setAlunos] = useState([]);
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [matricula, setMatricula] = useState("");
  const [erro, setErro] = useState(null);

  const navigate = useNavigate();
  const API_URL = "http://localhost:8080/api/alunos";

  const fetchAlunos = () => {
    fetch(API_URL)
      .then(response => {
        if (!response.ok) throw new Error("Erro ao acessar API");
        return response.json();
      })
      .then(data => setAlunos(data))
      .catch(err => setErro("Erro ao conectar no backend: " + err.message));
  };

  useEffect(() => {
    fetchAlunos();
  }, []);

  const adicionarAluno = (e) => {
    e.preventDefault();

    fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nome, email, matricula })
    })
      .then(response => {
        if (!response.ok) throw new Error("Erro ao adicionar aluno");
        return response.json();
      })
      .then(() => {
        setNome("");
        setEmail("");
        setMatricula("");
        fetchAlunos();
      })
      .catch(err => setErro("Erro ao adicionar aluno: " + err.message));
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <button onClick={() => navigate("/")}>⬅ Voltar ao Dashboard</button>

      <h1>🚀 Gestão de Alunos</h1>

      {erro && <p style={{ color: "red" }}>{erro}</p>}

      <h2>Adicionar Aluno</h2>
      <form onSubmit={adicionarAluno}>
        <input
          type="text"
          placeholder="Nome"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
          required
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="text"
          placeholder="Matrícula"
          value={matricula}
          onChange={(e) => setMatricula(e.target.value)}
          required
        />
        <button type="submit">Adicionar Aluno</button>
      </form>

      <h2>Lista de Alunos</h2>
      {alunos.length === 0 && <p>Nenhum aluno encontrado...</p>}
      <ul>
        {alunos.map(aluno => (
          <li key={aluno.id}>
            {aluno.nome} - {aluno.email} - {aluno.matricula}
          </li>
        ))}
      </ul>
    </div>
  );
}
