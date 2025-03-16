<template>
  <div>
    <h2>Transferências Agendadas</h2>
    <ul>
      <li v-for="t in transferencias" :key="t.id">
        {{ t.contaOrigem }} → {{ t.contaDestino }} | R$ {{ t.valor }} | {{ t.dataTransferencia }}
      </li>
    </ul>
  </div>
</template>

<script>
import api from "@/services/api";

export default {
  data() {
    return {
      transferencias: [],
    };
  },
  methods: {
    async carregarTransferencias() {
      try {
        const response = await api.get("/transferencias");
        this.transferencias = response.data;
      } catch (error) {
        alert("Erro ao carregar transferências.");
      }
    },
  },
  mounted() {
    this.carregarTransferencias();
  },
};
</script>
