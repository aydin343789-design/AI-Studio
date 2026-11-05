# AI-Studio

اپلیکیشن مستقل اندروید برای ساخت و مدیریت تصویر و ویدئو با هوش مصنوعی؛ با معماری ترکیبی آفلاین و آنلاین.

## وضعیت فعلی
این مخزن شامل اسکلت اولیه پروژه است. در این مرحله هیچ موتور تولید تصویر یا ویدئو به‌عنوان قابلیت عملیاتی عرضه نشده است.

## معماری
- Android: Kotlin + Jetpack Compose
- API: FastAPI
- پردازش آنلاین: اتصال آینده به ComfyUI / Diffusers و موتور ویدئو روی سرور GPU
- پردازش آفلاین: بررسی و افزودن موتور سازگار با سخت‌افزار واقعی دستگاه
- حالت‌ها: Offline / Online / Auto (پس از پیاده‌سازی و آزمون)

## ساخت APK آزمایشی
Workflow موجود در GitHub Actions می‌تواند نسخه Debug بسازد. نسخه Debug برای آزمایش است و تضمین نصب روی نسخه‌های انتشار را ندارد.

## امضای ثابت نسخه‌های انتشار
برای اینکه نسخه‌های بعدی بدون حذف برنامه روی نسخه قبلی نصب شوند، همه نسخه‌های Release باید با یک keystore ثابت امضا شوند. فایل keystore و رمزها نباید داخل مخزن قرار بگیرند.

در GitHub > Settings > Secrets and variables > Actions این Secrets را تنظیم کنید:
- ANDROID_KEYSTORE_BASE64
- ANDROID_KEYSTORE_PASSWORD
- ANDROID_KEY_ALIAS
- ANDROID_KEY_PASSWORD

پس از تنظیم این موارد، Workflow نسخه Release را با همان کلید امضا می‌کند. فایل keystore را در چند محل امن و آفلاین پشتیبان‌گیری کنید.

## امنیت
- هیچ API key یا رمز عبوری را داخل APK یا سورس عمومی قرار ندهید.
- مدل‌های حجیم را داخل Git قرار ندهید.
- مجوز کد و مجوز وزن‌های مدل باید جداگانه بررسی شوند.

## Backend محلی
برای اجرای API:
```bash
cd server
python -m venv .venv
pip install -r requirements.txt
uvicorn app.main:app --host 0.0.0.0 --port 8000
```
