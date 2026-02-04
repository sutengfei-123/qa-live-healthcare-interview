import { createApp } from 'vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import './style.css';
import App from './App.vue';
import router from './router';
import { createI18n } from 'vue-i18n';
import zh from './locales/zh.json';
import en from './locales/en.json';

const app = createApp(App);

const defaultLocale = (typeof localStorage !== 'undefined' && localStorage.getItem('locale')) || 'zh';

const i18n = createI18n({
	legacy: false,
	locale: defaultLocale,
	fallbackLocale: 'zh',
	messages: {
		zh,
		en
	}
});

app.use(Antd);
app.use(router);
app.use(i18n);
app.mount('#app');
