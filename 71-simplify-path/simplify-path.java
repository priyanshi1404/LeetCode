class Solution {
    public String simplifyPath(String path) {
        Stack <String> stack = new Stack<>();
        String[] paths= path.split("/");
        for(String currentPath: paths){
            if(currentPath.equals(".") || currentPath.trim().length()==0){
                continue;
            }
            else if(currentPath.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(currentPath);
            }
        }

        //Convert String into canonical path
        //it means the path must start with a slash
        StringBuilder canonicalPath= new StringBuilder();
        for(String cpath: stack){
            canonicalPath.append("/"); //in stringbuilder we use append instead of add
            canonicalPath.append(cpath);
        }
        return canonicalPath.toString().length()>0?canonicalPath.toString():"/";
        
    }
}