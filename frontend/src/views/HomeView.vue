<template>
  <div>
    <h1>Sistema de Agendamento de Transferências</h1>
    <TransferForm @atualizarLista="atualizarLista" />
    <TransferList ref="transferList" />
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
