# 📊 Assignment 4 — Graph Algorithms Performance Analysis

## 👥 Authors
- **Gapar** — Implemented **SCC (Kosaraju)** and **DAG Shortest Path**  
- **Aibek** — Implemented **Topological Sort** and **DAG Longest Path**

---

## 🎯 Project Goal
This project analyzes and compares the performance of **four graph algorithms** on directed graphs (DAGs):

1. **Strongly Connected Components (Kosaraju)**
2. **Topological Sort (DFS-based)**
3. **Shortest Path in DAG**
4. **Longest Path in DAG**

All algorithms were implemented in **Java** and tested on multiple input graphs of different sizes (small, medium, large).  
Performance results were collected automatically and visualized using **Python (matplotlib)**.

---

## ⚙️ How It Works
1. JSON graph files are stored in the `/data` folder.  
2. The `Main.java` file:
   - Loads each graph  
   - Runs all 4 algorithms  
   - Measures execution time using `System.nanoTime()`  
   - Saves results to `results.csv`
3. The `plot_results.py` script reads the CSV and builds performance charts (`performance.png`).

---

## 🗁 Project Structure
```
daa4ass/
│
├── src/
│   ├── graph/
│   │   ├── scc/ (Kosaraju)
│   │   ├── topo/ (Topological Sort)
│   │   ├── dagsp/ (Shortest & Longest Path)
│   │   ├── Graph.java
│   │   ├── GraphUtils.java
│   │   └── Main.java
│
├── data/              # JSON input graphs
├── results.csv        # Execution time results
├── plot_results.py    # Python plotting script
├── performance.png    # Visualization result
└── 💘 REPORT.docx     # Final report
```

---

## 🧪 How to Run

### ▶️ **Run Java Project**
```bash
javac -d out src/graph/**/*.java
java -cp out graph.Main
```

This will generate `results.csv` in the project root.

### 📊 **Run Python Visualization**
```bash
python plot_results.py
```
The script will create a performance chart: `performance.png`.

---

## 📊 Results Summary
| Algorithm | Average Time (ms) | Complexity | Description |
|------------|-------------------|-------------|--------------|
| SCC (Kosaraju) | ~0.9 | O(V + E) | Finds strongly connected components |
| Topological Sort | ~0.6 | O(V + E) | Orders vertices in DAG |
| DAG Shortest Path | ~1.6 | O(V + E) | Finds minimal path weights |
| DAG Longest Path | ~0.5 | O(V + E) | Finds maximal path weights |

---

## 🧠 Conclusions
- All algorithms scale **linearly (O(V+E))** with input size.
- SCC is the **heaviest** due to two DFS passes.
- Topological Sort is the **fastest**.
- Shortest and Longest Path algorithms rely on the topo order for correctness.
- The **logarithmic chart** confirms stability and scalability across datasets.

---

## 🧩 Tools Used
- **Java 24 (OpenJDK)**
- **Python 3.13**
- **Gson library** (for reading JSON)
- **Matplotlib + Pandas** (for plotting)

---

## 💘 Report
See `💘 REPORT.docx` for:
- Algorithm explanations
- Experimental setup
- Linear and logarithmic performance graphs
- Roles division and analysis
- Screenshots from the console and dataset visualizations

---

## 🏁 Grading Notes
✅ Code compiles and runs successfully  
✅ Output verified on all datasets  
✅ Timing and charts included  
✅ Report formatted correctly  
✅ Roles (Gapar & Aibek) clearly defined  

---

**© 2025 Astana IT University — Assignment 4, Design & Analysis of Algorithms**