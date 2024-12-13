package example;


import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static class Poll {
        String id;
        String question;
        List<String> options;
        LocalDateTime timeOfCreation;

        public Poll(String id, String question, List<String> options, LocalDateTime timeOfCreation) {
            this.id = id;
            this.question = question;
            this.options = options;
            this.timeOfCreation = timeOfCreation;
        }

        public String getId() {
            return id;
        }

        public String getQuestion() {
            return question;
        }
        public List<String> getOptions() {
            return options;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public LocalDateTime getTimeOfCreation() {
            return timeOfCreation;
        }

        @Override
        public String toString() {
            return "Poll created (  id = [" + id + "] question = [" + question + "] options = [" + options + "] timeofcreation [" + timeOfCreation + "]";
        }

    }
    static class Vote {
        int id;
        int userID;
        String option;
        LocalDateTime timeOfCreation;
    }
    static class User {
        String id;

        public User(String id) {
            this.id = id;
        }
    }

    static class PollManager {
        final Map<String, Poll> polls = new HashMap<>();
        final Map<String, Map<String, Integer>> optionFrequency = new HashMap<>();
        final Map<String, List<String>> canUserVote = new HashMap<>();
        int globPollId = 0;
        public Poll createPoll(String question, List<String> options) {
            Poll poll = new Poll(Integer.toString(++globPollId), question, options, LocalDateTime.now());
            polls.put(poll.getId(), poll);
            Map<String, Integer> optionFreq = optionFrequency.get(poll.getId());
            if(optionFreq == null) {
                optionFreq = new HashMap<>();
            }
            for(String option:options) {
                optionFreq.put(option, 0);
            }
            optionFrequency.put(poll.getId(), optionFreq);
            System.out.println(poll);
            return poll;
        }

        public void updatePoll(String pollId, String question, List<String> options) {
            if(!polls.containsKey(pollId)) {
                System.out.println("Poll not exists !!");
                return;
            }
            Poll poll = polls.get(pollId);
            poll.setQuestion(question);
            poll.setOptions(options);
            polls.put(pollId, poll);
        }

        public void deletePoll(String pollId) {
            if(!polls.containsKey(pollId)) {
                System.out.println("Poll not exists !!");
                return;
            }
            polls.remove(pollId);
        }

        public void voteInPoll(String pollId, String userId, String option) {
            if(!polls.containsKey(pollId)) {
                System.out.println("Poll not exists !!");
                return;
            }
            if(!canUserVote.containsKey(pollId)) {
                canUserVote.put(pollId, new ArrayList<>());
            }
            if(canUserVote.get(pollId).contains(userId)) {
                System.out.println("User has already voted !!");
                return;
            }
            canUserVote.get(pollId).add(userId);
            var optionFreq = optionFrequency.get(pollId);
            if(!optionFreq.containsKey(option)) {
                System.out.println("Option not exists !!");
                return;
            }
            optionFreq.put(option, optionFreq.get(option) + 1);
            optionFrequency.put(pollId, optionFreq);
        }

        public void viewPollResults(String pollId) {
            if(!polls.containsKey(pollId)) {
                System.out.println("Poll not exists");
                return;
            }
            var poll = polls.get(pollId);
            System.out.println("view poll results (" + pollId + ")" + "returns " + "question " + poll.getQuestion() + " , " + "options ");
            List<String> options = poll.getOptions();
            for(String option : options) {
                System.out.println(option + ": " + optionFrequency.get(pollId).get(option));
            }
            System.out.println("createdAt : " + LocalDateTime.now());
        }
    }


    public static void main(String[] args) {
        PollManager pollmanager = new PollManager();

        Poll poll = pollmanager.createPoll("What to eat today ?", Arrays.asList("Apple", "Banana", "Mango", "Fruit"));


        User user1 = new User(UUID.randomUUID().toString());
        User user2 = new User(UUID.randomUUID().toString());
        User user3 = new User(UUID.randomUUID().toString());
        User user4 = new User(UUID.randomUUID().toString());


        pollmanager.voteInPoll(poll.getId(), user1.id, "Apple");
        pollmanager.voteInPoll(poll.getId(), user2.id, "Banana");
        pollmanager.voteInPoll(poll.getId(), user3.id, "Mango");
        pollmanager.voteInPoll(poll.getId(), user4.id, "Apple");

        pollmanager.viewPollResults(poll.getId());
    }
}