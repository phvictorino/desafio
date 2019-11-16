<template>
  <v-tooltip bottom>
    <template v-slot:activator="{ on }">
      <v-btn
        color="primary"
        :disabled="disabled"
        small
        icon
        v-on="on"
        @click="$emit('click')"
      >
        <v-icon :color="cor" small>{{ icone }}</v-icon>
      </v-btn>
    </template>
    <span>{{ texto }}</span>
  </v-tooltip>
</template>

<script>
export default {
  props: {
    icone: {
      type: String,
      default: '',
    },
    texto: {
      type: String,
      default: '',
    },
    cor: {
      type: String,
      default: 'primary',
    },
    disabled: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style></style>
