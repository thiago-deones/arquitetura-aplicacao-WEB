import { useState, useEffect } from "react";
import axios from "axios";

export default function Alunos() {
  const [alunos, setAlunos] = useState([]);
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [matricula, setMatricula] = useState("");

  const API_URL = "http://localhost:8080/api/alunos";

  // Lista os alunos ao carregar a página
  useEffect(() => {
    fetchAlunos();
  }, []);

  const fetchAlunos = async () => {
    try {
      const response = await axios.get(API_URL);
      setAlunos(response.data);
    } catch (error) {
      console.error("Erro ao listar alunos:", error);
    }
  };

  const adicionarAluno = async (e) => {
    e.preventDefault();
    try {
      await axios.post(API_URL, { nome, email, matricula });
      setNome("");
      setEmail("");
      setMatricula("");
      fetchAlunos(); // atualizar lista
    } catch (error) {
      console.error("Erro ao adicionar aluno:", error);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Cadastro de Alunos</h2>

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

      <h3>Lista de Alunos</h3>
      <ul>
        {alunos.map((aluno) => (
          <li key={aluno.id}>
            {aluno.nome} - {aluno.email} - {aluno.matricula}
          </li>
        ))}
      </ul>
    </div>
  );
}
