import { createRouter, createWebHistory } from 'vue-router';
import AgendarTransferencia from '../views/AgendarTransferencia.vue';
import ListaTransferencias from '../views/ListaTransferencias.vue';

const routes = [
  { path: '/', component: ListaTransferencias },
  { path: '/agendar', component: AgendarTransferencia }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;