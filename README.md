# A legendary repository belonging to iii group 5.

## 補充
- 推薦使用Github桌面版的tutorial來練習一下操作！
- 請避免在main(主幹/主要分支)直接做修改🖐️
    - 請以自己的名稱(ex: ken_branch)創個自己個人的分支(create new branch)
    - **分支用完(合併完後)後請刪掉重創**，不然你分支的時間軸會脫離主幹(main)太遠
- Eclipse和VSCode是也git功能，不過操作上來說我目前只有GitHub Desktop比較會解釋😅

## 操作流程大概長這樣
1. Clone下我們的[儲存庫](https://github.com/AWildHuskyAppeard/legendary-repository.git)
2. **在本地(GitHub Desktop)創自己的分支(branch)、切換過去( = 確定你不在main上！)**，發佈(`publish`)到GitHub上 
    - (在本地) 創分支前，請先在你的本地main執行`fetch` + `pull`，以確保你的本地main時間軸 = 遠端main時間軸
    - 或是在GitHub上(遠端)創分支，然後在GitHub Desktop(本地)重新整理後就會看到你在GitHub上(遠端)新增的分支。選之
3. 以後所有動作(檔案的新增刪除修改)都請在自己的分支上做
    - `commit`、`push`...
4. 當進度你覺得差不多到一個段落時，使用`pull request`以提出合併(`merge`)的請求
    - 在下大任會去處理。比較急的話直接叫大任幫你處理
    - 各位熟悉GitHub之後也可自行執行`merge`看看！
5. 確定`merge`完成之後，刪了你的branch。回到第2步。
    - 不用擔心刪掉branch會刪掉檔案，裡面記載的是檔案變動而非檔案本身 (應該是啦)
        - 檔案變動 = 你在這支branch提交過的所有`commit` (`commit` = 一**組**變動)
    - **請不要砍到別人的branch！！**
