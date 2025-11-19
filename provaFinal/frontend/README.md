# Sistema Acadêmico - Frontend (React + Vite)

## Tecnologias
- React + Vite
- Fetch / Axios para consumir API
- Autenticação integrada (Basic / JWT)

## Como rodar localmente
cd frontend
npm install
npm run dev
Acesse http://localhost:5173

## Como consumir a API
- Base URL: http://localhost:8080/api
- Endpoints disponíveis: /alunos, /cursos, etc.
- Autenticação: incluir header Authorization, conforme backend

## Deploy (Vercel)
1. Conectar repo GitHub em Vercel
2. Build command: `npm run build`
3. Output directory: `dist`
