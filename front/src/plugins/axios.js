import axios from 'axios';

const customAxios = axios.create({
  baseURL: 'http://localhost:9000/',
});

export default customAxios;
