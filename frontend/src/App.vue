<template>
  <div class="container">
    <h1 class="title">Bem-vindo ao Sistema de Transferências 🚀</h1>
    <router-view />
  </div>
</template>

<style scoped>
.container {
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  box-sizing: border-box;
}

.title {
  text-align: center;
  font-size: 3rem;
  word-wrap: break-word;
  margin-bottom: 20px;
}

@media (max-width: 768px) {
  .title {
    font-size: 1.5rem;
  }
}

@media (max-width: 480px) {
  .title {
    font-size: 1.2rem;
  }
}
</style>
