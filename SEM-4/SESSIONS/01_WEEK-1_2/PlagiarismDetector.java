import java.util.*;

public class PlagiarismDetector {
    private Map<String, Set<String>> ngramIndex;
    private Map<String, Integer> documentNgramCount;
    private final int N;

    public PlagiarismDetector(int n) {
        this.ngramIndex = new HashMap<>();
        this.documentNgramCount = new HashMap<>();
        this.N = n;
    }

    private List<String> extractNgrams(String text) {
        String[] words = text.toLowerCase().replaceAll("[^a-z0-9\\\\s]", "").split("\\\\s+");
        List<String> ngrams = new ArrayList<>();
        if (words.length < N) return ngrams;

        for (int i = 0; i <= words.length - N; i++) {
            StringBuilder ngram = new StringBuilder();
            for (int j = 0; j < N; j++) {
                ngram.append(words[i + j]).append(j < N - 1 ? " " : "");
            }
            ngrams.add(ngram.toString());
        }
        return ngrams;
    }

    public void addDocument(String docId, String text) {
        List<String> ngrams = extractNgrams(text);
        documentNgramCount.put(docId, ngrams.size());

        for (String ngram : ngrams) {
            ngramIndex.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
        }
    }

    public void analyzeDocument(String docIdToAnalyze, String text) {
        List<String> ngrams = extractNgrams(text);
        System.out.println("-> Extracted " + ngrams.size() + " n-grams");

        if (ngrams.isEmpty()) return;

        Map<String, Integer> matchCounts = new HashMap<>();

        for (String ngram : ngrams) {
            Set<String> matchingDocs = ngramIndex.get(ngram);
            if (matchingDocs != null) {
                for (String matchDocId : matchingDocs) {
                    if (!matchDocId.equals(docIdToAnalyze)) {
                        matchCounts.put(matchDocId, matchCounts.getOrDefault(matchDocId, 0) + 1);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            String matchingDocId = entry.getKey();
            int matches = entry.getValue();
            double similarity = (double) matches / ngrams.size() * 100;

            System.out.printf("-> Found %d matching n-grams with \\\"%s\\\"\\n", matches, matchingDocId);
            if (similarity > 50) {
                System.out.printf("-> Similarity: %.1f%% (PLAGIARISM DETECTED)\\n", similarity);
            } else {
                System.out.printf("-> Similarity: %.1f%% (suspicious)\\n", similarity);
            }
        }
        
        // Add it to the system afterwards
        addDocument(docIdToAnalyze, text);
    }

    public static void main(String[] args) {
        PlagiarismDetector detector = new PlagiarismDetector(5);
        String doc1 = "The university needs to check student submissions against a database of previous essays to detect plagiarism.";
        String doc2 = "A university needs to check student submissions against a database of previous essays to detect plagiarism and simple string matching is too slow.";
        String doc3 = "Data structures and algorithms are essential for software engineering and passing technical interviews.";

        detector.addDocument("essay_089.txt", doc1);
        detector.addDocument("essay_092.txt", doc2);

        System.out.println("analyzeDocument(\"essay_123.txt\")");
        detector.analyzeDocument("essay_123.txt", "The university needs to check student submissions against a database of previous essays to detect plagiarism.");
    }
}
