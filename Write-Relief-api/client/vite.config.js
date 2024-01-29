import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api/letters': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      }
    },
  },
  build: {
    outDir: 'dist',  // The output directory for your build. Default is 'dist'.
    sourcemap: true,  // Generate source maps.
  }
})
