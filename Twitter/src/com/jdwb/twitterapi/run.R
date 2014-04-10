projectDir = getwd()

VERBOSE=TRUE

if (VERBOSE)
	print('Loading libraries and functions for project')

#library(twitteR)
library(plyr)
#library(ggplot2)

# load our score.sentiment() function:
source('F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/sentiment.R' )

print('Reading CSV file and doing vector conversion')
data <- read.csv('F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/iphone5s.csv')
data1 = as.vector(as.matrix(data$Tweet))

print('Reading file containing positive keywords')
pos = scan('F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/Positive.txt', what='character', comment.char=';')
pos.words = c(pos, 'upgrade', 'wait', 'waiting')

print('Reading file containing negative keywords')
neg = scan('F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/Negative.txt', what='character', comment.char=';')
neg.words = c(neg, 'wtf', 'epicfail')

print('Calculating scores for tweets')
result = score.sentiment(data1, data$Continent, pos.words, neg.words)
write.csv(result, file="F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/result.csv")
print('Done')
print('Results stored in result.csv in current working directory')