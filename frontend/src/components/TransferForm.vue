<template>
  <form @submit.prevent="agendarTransferencia">
    <div class="input-group">
      <label>Conta de Origem:</label>
      <input type="text" v-model="transferencia.contaOrigem" required />
    </div>

    <div class="input-group">
      <label>Conta de Destino:</label>
      <input type="text" v-model="transferencia.contaDestino" required />
    </div>

    <div class="input-group">
      <label>Valor:</label>
      <input type="number" v-model="transferencia.valor" required />
    </div>

    <div class="input-group">
      <label>Data da Transferência:</label>
      <input type="date" v-model="transferencia.dataTransferencia" required />
    </div>

    <button type="submit" class="btn">Agendar</button>

    <p v-if="mensagem" :class="mensagemErro ? 'mensagem erro' : 'mensagem'">{{ mensagem }}</p>
  </form>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      transferencia: {
        contaOrigem: "",
        contaDestino: "",
        valor: "",
        dataTransferencia: "",
      },
      mensagem: "",
      mensagemErro: false,
    };
  },
  methods: {
    async agendarTransferencia() {
      console.log("Enviando:", this.transferencia);
      try {
        const response = await axios.post("http://localhost:8080/transferencias", this.transferencia);
        console.log("Resposta da API:", response);
        this.mensagem = "Transferência agendada com sucesso!";
        this.mensagemErro = false;
        this.$emit("atualizarLista"); // Atualiza a lista após o agendamento
      } catch (error) {
        if (error.response && error.response.status === 400) {
          this.mensagem = "Erro: Periodo de transferência deve ser menor que 50 dias.";
          this.mensagemErro = true;
          alert("Não há taxa aplicável para esta transferência: " + error.response.data.error);
        } else {
          this.mensagem = "Erro ao agendar a transferência. Verifique os dados.";
          this.mensagemErro = true;
        }
        console.error("Erro ao agendar transferência:", error.response ? error.response.data : error);
      }
    },
  },
};
</script>

<style scoped>
.input-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 15px;
}

label {
  font-weight: bold;
  margin-bottom: 5px;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.btn {
  background: #007bff;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn:hover {
  background: #0056b3;
}

.mensagem {
  margin-top: 10px;
  font-weight: bold;
  color: green;
}

.erro {
  color: red;
}
</style>