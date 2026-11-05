package com.aydin.aistudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AIStudioApp() }
    }
}

@Composable
private fun AIStudioApp() {
    var mode by remember { mutableStateOf("Auto") }
    MaterialTheme {
        Scaffold { padding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                item {
                    Text("AI-Studio", style = MaterialTheme.typography.headlineLarge)
                    Text("استودیوی هوشمند تصویر و ویدئو", style = MaterialTheme.typography.titleMedium)
                }
                item {
                    Text("حالت اجرا", style = MaterialTheme.typography.titleMedium)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        listOf("Offline", "Online", "Auto").forEach { option ->
                            FilterChip(
                                selected = mode == option,
                                onClick = { mode = option },
                                label = { Text(option) },
                                modifier = Modifier.padding(end = 6.dp)
                            )
                        }
                    }
                    Text(
                        "این انتخاب فعلاً نمایشی است؛ موتورهای تولید تا زمان اتصال و آزمون فعال نیستند.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                item {
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("ساخت تصویر", style = MaterialTheme.typography.titleLarge)
                            Text("پس از اتصال موتور تصویر، توضیح تصویر و تنظیمات اینجا قرار می‌گیرد.")
                            OutlinedButton(onClick = {}) { Text("به‌زودی") }
                        }
                    }
                }
                item {
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("ساخت ویدئو", style = MaterialTheme.typography.titleLarge)
                            Text("پردازش ویدئو به موتور سازگار و معمولاً GPU سرور نیاز دارد.")
                            OutlinedButton(onClick = {}) { Text("به‌زودی") }
                        }
                    }
                }
                item {
                    Text("نسخه 1.0.0 • نسخه اولیه زیرساخت", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
    }
}
