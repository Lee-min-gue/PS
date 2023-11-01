scores = [int(input()) for _ in range(8)]
sorted_scores = sorted([(score, idx+1) for idx, score in enumerate(scores)], reverse=True)
total_score = sum([score[0] for score in sorted_scores[:5]])
selected_questions = sorted([score[1] for score in sorted_scores[:5]])

print(total_score)
for question in selected_questions:
    print(question, end=' ')
