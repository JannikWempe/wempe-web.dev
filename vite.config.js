import {defineConfig} from 'vite'
import svelte from 'rollup-plugin-svelte'

const production = (process.env.NODE_ENV === 'production')

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    svelte({
      emitCss: false,
      dev: !production,
    })
  ]
})
