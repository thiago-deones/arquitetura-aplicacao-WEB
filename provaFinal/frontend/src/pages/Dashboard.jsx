import { Link } from "react-router-dom";

export default function Dashboard() {
  return (
    <div className="container">
      <h1>Sistema Acadêmico</h1>

      <nav>
        <Link to="/alunos">Alunos</Link>
        <Link to="/cursos">Cursos</Link>
      </nav>
    </div>
  );
}
