# راه‌اندازی امضای دائمی APK

این پروژه عمداً بدون کلید امضا در مخزن نگهداری می‌شود. برای ساخت Release قابل ارتقا، چهار GitHub Actions Secret لازم است.

## افزودن Secrets از موبایل یا دسکتاپ

1. وارد مخزن خصوصی‌سازی‌نشده اما عمومی [AI-Studio](https://github.com/aydin343789-design/AI-Studio) شوید.
2. به **Settings → Secrets and variables → Actions** بروید.
3. گزینه **New repository secret** را بزنید.
4. چهار Secret زیر را دقیقاً با همین نام بسازید:
   - `ANDROID_KEYSTORE_BASE64`: مقدار کامل Base64 موجود در فایل خصوصی `AI-Studio-GitHub-Secrets.txt`
   - `ANDROID_KEYSTORE_PASSWORD`: رمز keystore در همان فایل
   - `ANDROID_KEY_ALIAS`: نام alias در همان فایل
   - `ANDROID_KEY_PASSWORD`: رمز کلید در همان فایل

## نکات امنیتی حیاتی
- فایل `AI-Studio-release.jks` و فایل `AI-Studio-GitHub-Secrets.txt` را در GitHub، پیام‌رسان عمومی یا مخزن قرار ندهید.
- حداقل دو نسخه پشتیبان آفلاین و امن از فایل JKS نگه دارید.
- اگر keystore یا رمزهایش گم شوند، نسخه‌های بعدی با امضای جدید روی نصب فعلی قابل ارتقا نخواهند بود.
- هرگز کلید جدید نسازید مگر اینکه عمداً بخواهید برنامه‌ای جداگانه با شناسه متفاوت منتشر کنید.

پس از ثبت هر چهار Secret، از **Actions → Android APK → Run workflow**، شاخه `main` را انتخاب و اجرا کنید. Workflow فقط Release امضاشده می‌سازد و در صورت نبود Secretها متوقف می‌شود؛ APK آزمایشی با امضای متغیر تولید نمی‌کند.
