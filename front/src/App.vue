<template>
  <v-app>
    <v-container>
      <propostas />
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  components: {
    propostas: () => import('@/components/Propostas.vue'),
  },

  data: () => ({
    //
  }),
};
</script>
