import pandas as pd
import matplotlib.pyplot as plt

# === 1. Load CSV ===
df = pd.read_csv('results.csv')

# === 2. Fix commas if present ===
for col in df.columns[1:]:
    df[col] = df[col].astype(str).str.replace(',', '.').astype(float)

# === 3. Sort data by number of vertices ===
df = df.sort_values(by='n')

print("✅ Data loaded and sorted:")
print(df)

# === 4. Linear Scale Plot ===
plt.figure(figsize=(10, 6))
plt.plot(df['n'], df['scc_ms'], marker='o', label='SCC (Kosaraju)')
plt.plot(df['n'], df['topo_ms'], marker='s', label='Topological Sort')
plt.plot(df['n'], df['short_ms'], marker='^', label='DAG Shortest Path')
plt.plot(df['n'], df['long_ms'], marker='d', label='DAG Longest Path')

plt.title('Performance Analysis of Graph Algorithms (Linear Scale)', fontsize=14, fontweight='bold')
plt.xlabel('Number of Vertices (n)', fontsize=12)
plt.ylabel('Execution Time (ms)', fontsize=12)
plt.legend(title='Algorithms', fontsize=10)
plt.grid(True, linestyle='--', alpha=0.6)
plt.tight_layout()
plt.savefig('performance_linear.png', dpi=300)
plt.show()

# === 5. Logarithmic Scale Plot ===
plt.figure(figsize=(10, 6))
plt.plot(df['n'], df['scc_ms'], marker='o', label='SCC (Kosaraju)')
plt.plot(df['n'], df['topo_ms'], marker='s', label='Topological Sort')
plt.plot(df['n'], df['short_ms'], marker='^', label='DAG Shortest Path')
plt.plot(df['n'], df['long_ms'], marker='d', label='DAG Longest Path')

plt.yscale('log')  # 🔥 Логарифмическая шкала по оси Y
plt.title('Performance Analysis of Graph Algorithms (Log Scale)', fontsize=14, fontweight='bold')
plt.xlabel('Number of Vertices (n)', fontsize=12)
plt.ylabel('Execution Time (ms, log scale)', fontsize=12)
plt.legend(title='Algorithms', fontsize=10)
plt.grid(True, linestyle='--', alpha=0.6, which='both')
plt.tight_layout()
plt.savefig('performance_log.png', dpi=300)
plt.show()

print("\n📊 Graphs saved as:")
print(" - performance_linear.png")
print(" - performance_log.png ✅")
