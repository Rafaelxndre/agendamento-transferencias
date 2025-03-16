<template>
  <form @submit.prevent="agendarTransferencia">
    <input v-model="transferencia.contaOrigem" placeholder="Conta de Origem" />
    <input v-model="transferencia.contaDestino" placeholder="Conta de Destino" />
    <input v-model="transferencia.valor" type="number" placeholder="Valor" />
    <input v-model="transferencia.dataTransferencia" type="date" />

    <button type="submit">Agendar Transferência</button>
  </form>
</template>

<script>
import api from "@/services/api";

export default {
  data() {
    return {
      transferencia: {
        contaOrigem: "",
        contaDestino: "",
        valor: null,
        dataTransferencia: "",
      },
    };
  },
  methods: {
    async agendarTransferencia() {
      try {
        await api.post("/transferencias", this.transferencia);
        alert("Transferência agendada com sucesso!");
        this.$emit("atualizarLista"); // Atualiza a lista após o agendamento
      } catch (error) {
        alert("Erro ao agendar transferência.");
      }
    },
  },
};
</script>
