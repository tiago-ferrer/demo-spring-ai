#!/bin/sh

# Inicia o servidor Ollama em segundo plano
ollama serve &

# Aguarda o servidor ficar disponível
until curl -s http://localhost:11434 > /dev/null; do
  echo "⏳ Aguardando Ollama iniciar..."
  sleep 1
done

# Puxa o modelo mistral se ainda não existir
if ! ollama list | grep -q 'mistral'; then
  echo "⬇️ Baixando modelo 'mistral'..."
  ollama pull mistral
else
  echo "✅ Modelo 'mistral' já está presente."
fi

# Mantém o processo principal rodando
wait
