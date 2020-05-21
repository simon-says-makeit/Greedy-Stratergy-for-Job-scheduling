Implement a greedy strategy which takes a list of Job objects (each Job object consists of an id (integer), a startTime (float), and a finishTime (float)), and outputs a selection of compatible jobs, chosen according to a greedy stratergy which prioritises the shortest length.

Returns a non-conflicting selection of jobs from the input list, chosen according to the shortest interval strategy, i.e. jobs are considered in order of shortest to longest interval length, each job is included if and only if it doesn't conflict with previously chosen jobs.
