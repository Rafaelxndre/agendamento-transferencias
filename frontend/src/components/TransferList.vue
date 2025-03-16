<template>
  <div>
    <h2>Lista de Transferências</h2>
    <table v-if="transferencias.length">
      <thead>
        <tr>
          <th>Conta Origem</th>
          <th>Conta Destino</th>
          <th>Valor</th>
          <th>Taxa</th>
          <th>Data Agendamento</th>
          <th>Data Transferência</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="transferencia in transferencias" :key="transferencia.id">
          <td>{{ transferencia.contaOrigem }}</td>
          <td>{{ transferencia.contaDestino }}</td>
          <td>R$ {{ transferencia.valor.toFixed(2) }}</td>
          <td>R$ {{ transferencia.taxa.toFixed(2) }}</td>
          <td>{{ transferencia.dataAgendamento }}</td>
          <td>{{ transferencia.dataTransferencia }}</td>
        </tr>
      </tbody>
    </table>
    <p v-else>Nenhuma transferência cadastrada.</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      transferencias: [],
    };
  },
  methods: {
    async carregarTransferencias() {
      try {
        const response = await axios.get("http://localhost:8080/transferencias");
        this.transferencias = response.data;
      } catch (error) {
        console.error("Erro ao carregar transferências:", error);
      }
    },
  },
  mounted() {
    this.carregarTransferencias();
  },
};
</script>
