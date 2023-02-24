    
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int res = Integer.MAX_VALUE;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2!=0){
                nums[i] = nums[i] * 2;
            }
            if(nums[i] < min) min = nums[i];
            pQueue.add(nums[i]);
        }
  
        while(pQueue.peek()%2==0){
            int num = pQueue.poll();
            res = Math.min(num-min, res);
            min = Math.min(num/2, min);
            pQueue.add(num / 2);
        }

        return Math.min(res, pQueue.peek() - min);
