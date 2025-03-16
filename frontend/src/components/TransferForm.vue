<template>
  <div>
    <h2>Agendar Transferência</h2>
    <form @submit.prevent="agendarTransferencia">
      <label>Conta de Origem:</label>
      <input v-model="transferencia.contaOrigem" required />

      <label>Conta de Destino:</label>
      <input v-model="transferencia.contaDestino" required />

      <label>Valor:</label>
      <input type="number" v-model="transferencia.valor" required />

      <label>Data da Transferência:</label>
      <input type="date" v-model="transferencia.dataTransferencia" required />

      <button type="submit">Agendar</button>
    </form>
    <p v-if="mensagem" class="mensagem">{{ mensagem }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      transferencia: {
        contaOrigem: "",
        contaDestino: "",
        valor: null,
        dataTransferencia: "",
      },
      mensagem: "",
    };
  },
  methods: {
    async agendarTransferencia() {
  try {
    await axios.post("http://localhost:8080/transferencias", this.transferencia);
    this.mensagem = "Transferência agendada com sucesso!";
    this.$emit("atualizarLista"); // Atualiza a lista após o agendamento
  } catch (error) {
    this.mensagem = "Erro ao agendar a transferência. Verifique os dados.";
    console.error("Erro:", error);
  }
},
  },
};
</script>

<style scoped>
.mensagem {
  margin-top: 10px;
  font-weight: bold;
  color: green;
}
</style>
