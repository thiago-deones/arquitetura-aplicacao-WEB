import { useEffect, useState } from "react";
import api from "../api/api";

export default function Cursos() {
  const [cursos, setCursos] = useState([]);
  const [nome, setNome] = useState("");
  const [cargaHoraria, setCargaHoraria] = useState("");

  useEffect(() => {
    carregarCursos();
  }, []);

  const carregarCursos = async () => {
    const response = await api.get("/cursos");
    setCursos(response.data);
  };

  const cadastrarCurso = async () => {
    await api.post("/cursos", {
      nome,
      cargaHoraria
    });

    setNome("");
    setCargaHoraria("");
    carregarCursos();
  };

  return (
    <div className="container">
      <h2>Cursos</h2>

      <input placeholder="Nome do curso" value={nome} onChange={e => setNome(e.target.value)} />
      <input placeholder="Carga Horária" value={cargaHoraria} onChange={e => setCargaHoraria(e.target.value)} />

      <button onClick={cadastrarCurso}>Cadastrar</button>

      <ul>
        {cursos.map(curso => (
          <li key={curso.id}>
            {curso.nome} - {curso.cargaHoraria}h
          </li>
        ))}
      </ul>
    </div>
  );
}
