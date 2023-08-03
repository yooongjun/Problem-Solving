package groupStudy.day03.greedy.personal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 신입 사원
 */
public class BOJ1946 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            int numberOfApplicants = Integer.parseInt(bufferedReader.readLine());
            PriorityQueue<Applicant> applicants = new PriorityQueue<>((applicantA, applicantB) -> applicantA.documentRank - applicantB.documentRank);

            for (int i = 0; i < numberOfApplicants; i++) {
                String[] s = bufferedReader.readLine().split(" ");
                int docucmentRank = Integer.parseInt(s[0]);
                int interviewRank = Integer.parseInt(s[1]);

                applicants.add(new Applicant(docucmentRank, interviewRank));
            }

            int result = selectApplications(applicants);
            System.out.println(result);
        }
    }

    private static int selectApplications(PriorityQueue<Applicant> applicants) {

        if(applicants.isEmpty()) return -1;

        int currentMinValueOfInterviewRank = applicants.peek().interviewRank;
        int numberOfSelectedApplicants = 0;

        while (!applicants.isEmpty()) {
            Applicant curApplicant = applicants.poll();

            if (curApplicant.interviewRank <= currentMinValueOfInterviewRank) {
                currentMinValueOfInterviewRank = curApplicant.interviewRank;
                numberOfSelectedApplicants++;
                continue;
            }
        }

        return numberOfSelectedApplicants;
    }

    static private class Applicant{
        int documentRank;
        int interviewRank;

        public Applicant(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }
    }

}
