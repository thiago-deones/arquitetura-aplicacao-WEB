import { useEffect, useState } from "react";
import api from "../api/api";

export default function Alunos() {
  const [alunos, setAlunos] = useState([]);
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [matricula, setMatricula] = useState("");

  useEffect(() => {
    carregarAlunos();
  }, []);

  const carregarAlunos = async () => {
    const response = await api.get("/alunos");
    setAlunos(response.data);
  };

  const cadastrarAluno = async () => {
    await api.post("/alunos", {
      nome, email, matricula
    });

    setNome("");
    setEmail("");
    setMatricula("");
    carregarAlunos();
  };

  return (
    <div className="container">
      <h2>Alunos</h2>

      <input placeholder="Nome" value={nome} onChange={e => setNome(e.target.value)} />
      <input placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
      <input placeholder="Matrícula" value={matricula} onChange={e => setMatricula(e.target.value)} />

      <button onClick={cadastrarAluno}>Cadastrar</button>

      <ul>
        {alunos.map(aluno => (
          <li key={aluno.id}>
            {aluno.nome} - {aluno.email}
          </li>
        ))}
      </ul>
    </div>
  );
}
