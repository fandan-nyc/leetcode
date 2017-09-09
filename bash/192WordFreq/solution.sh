cat /tmp/data | tr -s ' ' '\n'   | sort | uniq -c  | sort -r | awk '{print $2,$1}'
