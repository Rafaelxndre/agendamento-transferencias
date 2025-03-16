<template>
  <div>
    <h2>Lista de Transferências</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
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
          <td>{{ transferencia.id }}</td>
          <td>{{ transferencia.contaOrigem }}</td>
          <td>{{ transferencia.contaDestino }}</td>
          <td>{{ transferencia.valor }}</td>
          <td>{{ transferencia.taxa }}</td>
          <td>{{ transferencia.dataAgendamento }}</td>
          <td>{{ transferencia.dataTransferencia }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      transferencias: [], // Array vazio para receber os dados da API
    };
  },
  methods: {
    async carregarTransferencias() {
      try {
        const response = await fetch("http://localhost:8080/transferencias"); // Ajuste a URL conforme necessário
        this.transferencias = await response.json();
      } catch (error) {
        console.error("Erro ao carregar transferências:", error);
      }
    },
  },
  mounted() {
    this.carregarTransferencias(); // Carregar os dados ao montar o componente
  },
};
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}
th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}
th {
  background-color: #f4f4f4;
}
</style>