class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        op = n
        cl = n
        def helper(op,cl,path):
            if cl == 0:
                res.append(path)
                return
            if op<cl:
                if op !=0:
                    helper(op-1,cl,path+"(")
                helper(op,cl-1,path+")")
            else:
                helper(op-1,cl,path+"(")
        helper(op,cl,"")
        print(res)
        return res