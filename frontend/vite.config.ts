import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vite.dev/config/
export default defineConfig({
  base: './',       // ← relative paths instead of absolute `/`
  publicDir: 'public',   // ← default, makes flexible.js land at dist/flexible.js
  plugins: [vue()],
  // … any proxy/server settings you had …
});
