<template>
  <v-dialog v-model="dialog">
    <v-card>
      teste
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  data: () => ({
    dialog: false,
  }),
  created() {
    this.dialog = this.$route.params.modal;
  },
};
</script>

<style>

</style>
