#include <iostream>
#include <vector>

using namespace std;

int bs(vector<int>& list, int num){

    int left=0, right=list.size(), mid;
    while (left < right){
        mid = (left+right)/2;

        if(list[mid]<num)
            left = mid+1;
        else{
            right = mid;
        }
    }
    return right;
}

int main() {
    int n;
    cin>> n;
    vector<int> nums(n);

    for(int i=0;i<n;i++){
        cin>> nums[i];
    }

    vector<int> list;
    list.push_back(nums[0]);

    for(int i=1;i<n;i++){
        if(list.back() < nums[i]){
            list.push_back(nums[i]);
        }
        else{
            int idx = bs(list, nums[i]);
            list[idx] = nums[i];
        }
    }

    cout<<list.size();

    return 0;
}



