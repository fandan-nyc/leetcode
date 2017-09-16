
# Solution 1
awk 'FNR == 10 {print }'  file.txt
# OR
awk 'NR == 10' file.txt

# Solution 2
sed -n 10p file.txt

# Solution 3
tail n+10 file.txt | head -1
tail +10 file.txt | head -1
