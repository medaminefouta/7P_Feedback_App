import './assets/main.css'

import { createApp } from 'vue'

import App from './App.vue'

import '@mdi/font/css/materialdesignicons.css'

import 'vuetify/styles'
import { createVuetify } from 'vuetify'

const app = createApp(App)

const vuetify = createVuetify()

app.use(vuetify)

app.mount('#app')
