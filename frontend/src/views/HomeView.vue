<template>
  <div class="container">
    <h1 class="title">Sistema de Agendamento de Transferências</h1>

    <div class="card">
      <TransferForm @atualizarLista="atualizarLista" />
    </div>

    <div class="card">
      <TransferList ref="transferList" />
    </div>
  </div>
</template>

<script>
import TransferForm from "@/components/TransferForm.vue";
import TransferList from "@/components/TransferList.vue";

export default {
  components: { TransferForm, TransferList },
  methods: {
    atualizarLista() {
      this.$refs.transferList.carregarTransferencias();
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 900px;
  margin: 0 auto;
  padding: 20px;
}

.title {
  text-align: center;
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
}

.card {
  background: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
}
</style>
