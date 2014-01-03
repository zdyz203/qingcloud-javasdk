package com.qingcloud.model.trans;

public class Trans {
	
	/**
	 * 
	 * 获取一个或多个主机
	 * 可根据主机ID, 状态, 主机名称, 映像ID 作过滤条件, 来获取主机列表。 
	 * 如果不指定任何过滤条件, 默认返回你所拥有的所有主机。
	 * 
	 */
	public static final String DescribeInstances	= 	"DescribeInstances";
	/**
	 * 创建指定配置，指定数量的主机。
	 * 当你创建主机时，主机会先进入 pending 状态，直到创建完成后，变为 running 状态。
	 *  你可以使用 DescribeInstances 检查主机状态。
	 *  创建主机时，一旦参数 vxnets.n 包含基础网络（即： vxnet-0 ），
	 *  则需要指定防火墙 security_group，如果没有指定，青云会自动使用缺省防火墙。
	 *  青云给主机定义了几种经典配置，可通过参数 instance_type 指定，配置列表请参考 Instance Types 。 
	 *  如果经典配置不能满足你的需求，可通过参数 cpu, memory 自定义主机配置。
	 *  如果参数中既指定 instance_type ，又指定了 cpu 和 memory ， 则以指定的 cpu 和 memory 为准。
	 */
	public static final String RunInstances			= 	"RunInstances";
	/**
	 * 
	 *  销毁一台或多台主机。
	 *  销毁主机的前提，是此主机已建立租用信息（租用信息是在创建主机成功后， 几秒钟内系统自动建立的）。
	 *  所以正在创建的主机（状态为 pending ）， 以及刚刚创建成功但还没有建立租用信息的主机，是不能被销毁的。
	 *  警告 已销毁的主机青云会为你保留2小时，如果误操作，请及时与我们联系。
	 *  
	 */
	public static final String TerminateInstances	= 	"TerminateInstances";
	/**
	 * 
	 * 启动一台或多台关闭状态的主机。
	 * 主机只有在关闭 stopped 状态才能被启动，如果处于非关闭状态，则返回错误信息。
	 * 主机在关闭状态时，青云只收取主机操作系统所占磁盘空间的费用，价格与硬盘相同，
	 *  即：每 10G 收费 0.02 元（注：Linux 系统为 20G，Windows 系统为 50G）。 
	 *  当主机启动后，计费系统会继续对此主机的计算资源进行扣费。
	 *  青云会根据你实际使用的时长收费（精确到秒），所以你可以随时启动、关闭主机， 而不用考虑计费周期的限制。
	 *  
	 */
	public static final String StartInstances		= 	"StartInstances";
	/**
	 * 
	 * 关闭一台或多台运行状态的主机。
	 * 主机只有在运行 running 状态才能被关闭，如果处于非运行状态，则返回错误信息。
	 * 主机在关闭状态时，青云只收取主机操作系统所占磁盘空间的费用，价格与硬盘相同，
	 *  即：每 10G 收费 0.02 元（注：Linux 系统为 20G，Windows 系统为 50G）。 
	 *  当主机启动后，计费系统会继续对此主机的计算资源进行扣费。
	 *  青云会根据你实际使用的时长收费（精确到秒），所以你可以随时启动、关闭主机， 而不用考虑计费周期的限制。
	 *  
	 */
	public static final String StopInstances		= 	"StopInstances";
	/**
	 * 
	 * 重启一台或多台运行状态的主机。
	 * 主机只有在运行 running 状态才能被重启，如果处于非运行状态，则返回错误信息。
	 * 
	 */
	public static final String RestartInstances		= 	"RestartInstances";
	/**
	 * 
	 * 将一台或多台主机的系统盘重置到初始状态。 被重置的主机必须处于运行（ running ）或关闭（ stopped ）状态。
	 * 重置只涉及系统盘数据，不包含主机所加载的硬盘。
	 * 
	 */
	public static final String ResetInstances		= 	"ResetInstances";
	/**
	 * 
	 * 修改主机配置，包括 CPU 和内存。主机状态必须是关闭的 stopped ，不然会返回错误。
	 * 如果使用预设的 instance_type ，参数中就不需再指定 CPU 或内存，配置列表请参考 Instance Types 。
	 * 如果参数中没有指定 instance_type ，则必须指定 cpu 和 memory。
	 * 如果参数中既指定 instance_type ，又指定了 cpu 和 memory ， 则以指定的 cpu 和 memory 为准。
	 * 
	 */
	public static final String ResizeInstances		= 	"ResizeInstances";
	/**
	 * 
	 * 修改一台主机的名称和描述。
	 * 修改时不受主机状态限制。一次只能修改一台主机。
	 * 
	 */
	public static final String ModifyInstanceAttributes	= 	"ModifyInstanceAttributes";
	
	
	/**
	 * 获取一个或多个硬盘
	 * 可根据硬盘ID，状态，硬盘名称作过滤条件，来获取硬盘列表。 
	 * 如果不指定任何过滤条件，默认返回你所拥有的所有硬盘。
	 *  如果指定不存在的硬盘ID，或非法状态值，则会返回错误信息。
	 */
	public static final String DescribeVolumes	= 	"DescribeVolumes";
	/**
	 * 创建一块或多块硬盘，每块硬盘都可加载到任意一台主机中。
	 */
	public static final String CreateVolumes	= 	"CreateVolumes";
	/**
	 * 删除一块或多块硬盘。硬盘须在可用（ available ）状态下才能被删除，
	 * 已加载到主机的硬盘需先卸载后才能删除。
	 */
	public static final String DeleteVolumes	= 	"DeleteVolumes";
	/**
	 * 将一块或多块“可用”（ available ）状态的硬盘加载到某台”运行”（ running ） 或”关机”（ stopped ）状态的主机。
	 * 硬盘加载成功后，需要到加载的主机上进一步手动操作
	 */
	public static final String AttachVolumes	= 	"AttachVolumes";
	/**
	 * 将一块或多块“使用中”（ in-use ）状态的硬盘从某台主机中卸载。
	 * 卸载前要保证已先从操作系统中 unmount 了硬盘，不然会返回错误信息。
	 * 不管卸载是否成功，都不会对硬盘内的数据产生影响。
	 */
	public static final String DetachVolumes	= 	"DetachVolumes";
	/**
	 * 给一块或多块“可用”（ available ）状态的硬盘扩大容量。
	 * 只允许扩大容量，不支持减小。
	 */
	public static final String ResizeVolumes	= 	"ResizeVolumes";
	/**
	 * 修改一块硬盘的名称和描述。
	 * 修改时不受硬盘状态限制。
	 * 一次只能修改一块硬盘。
	 */
	public static final String ModifyVolumeAttributes	= 	"ModifyVolumeAttributes";
	
	/**
	 * 可根据私有网络ID作过滤条件，获取私有网络列表。 如果不指定任何过滤条件，默认返回你所拥有的所有私有网络。
	 */
	public static final String DescribeVxnets	= 	"DescribeVxnets";
	/**
	 * 创建新的私有网络。
	 * 青云私有网络有两种类型： 受管私有网络 ( vxnet_type=1 ) 和 自管私有网络 ( vxnet_type=0 ) ，
	 * 受管私有网络可以使用青云路由器来配置和管理其网络，使得网络搭建更方便快捷。
	 * 自管私有网络需要您自行配置和管理网络，适用于对底层网络有特殊需求的用户。
	 */
	public static final String CreateVxnets	= 	"CreateVxnets";
	/**
	 * 删除私有网络。
	 * 只能删除没有主机的私有网络，若删除时仍然有主机在此网络中，会返回错误信息。 可通过 LeaveVxnet 移出主机。
	 */
	public static final String DeleteVxnets	= 	"DeleteVxnets";
	/**
	 *将主机加入到私有网络。
	 *警告 一台主机最多只能加入一个受管网络 ( 包括基础网络vxnet-0 )
	 */
	public static final String JoinVxnet	= 	"JoinVxnet";
	/**
	 *将主机从私有网络中断开。
	 */
	public static final String LeaveVxnet	= 	"LeaveVxnet";
	/**
	 * 修改私有网络的名称和描述。
	 * 一次只能修改一个私有网络。
	 */
	public static final String ModifyVxnetAttributes	= 	"ModifyVxnetAttributes";
	/**
	 * 获取私有网络中的主机。
	 * 可通过主机ID，映像ID，主机配置类型，主机状态作为过滤条件进行筛选。
	 */
	public static final String DescribeVxnetInstances	= 	"DescribeVxnetInstances";
	
	/**
	 * 获取一个或多个路由器
	 * 可根据路由器ID，状态，路由器名称作过滤条件，来获取路由器列表。 
	 * 如果不指定任何过滤条件，默认返回你所拥有的所有路由器。
	 *  如果指定不存在的路由器ID，或非法状态值，则会返回错误信息。	
	 */
	public static final String DescribeRouters		= 	"DescribeRouters";
	/**
	 * 创建一台或多台路由器。路由器用于受管私有网络之间互联，并提供三项附加服务：DHCP 服务、端口转发、VPN 隧道服务。
	 * 这个API只负责路由器的创建工作，如果需要通过路由器将自己名下的受管私有网络连接起来，请查看 JoinRouter。
	 * 如果需要配置端口转发规则或打开VPN 隧道服务，请查看 AddRouterStatics 和 UpdateRouters。
	 */
	public static final String CreateRouters		= 	"CreateRouters";
	/**
	 * 删除一台或多台路由器。
	 * 销毁路由器的前提，是此路由器已建立租用信息（租用信息是在创建路由器成功后， 几秒钟内系统自动建立的）。
	 * 所以正在创建的路由器（状态为 pending ）， 以及刚刚创建成功但还没有建立租用信息的路由器，是不能被销毁的。
	 * 警告 被删除的路由器会被立即系统回收，不具有可恢复的功能。
	 */
	public static final String DeleteRouters		= 	"DeleteRouters";
	/**
	 * 更新一台或多台路由器的配置信息。当配置发生变更之后，需要执行本操作使配置生效。
	 * 可以使路由器配置发生变更的操作为 AddRouterStatics 和 DeleteRouterStatics 和 ModifyRouterAttributes。
	 * 只有在处于 active 状态的路由器才能支持此操作，如果处于非活跃状态，则返回错误信息。
	 */
	public static final String UpdateRouters		= 	"UpdateRouters";
	/**
	 * 关闭一台或多台路由器。
	 * 路由器只有在运行 active 状态才能被关闭，如果处于非运行状态，则返回错误信息。
	 * 注解 关闭路由器之后，路由器将不再收费。
	 */
	public static final String PowerOffRouters		= 	"PowerOffRouters";
	/**
	 * 启动一台或多台路由器。
	 * 路由器只有在关闭 poweroffed 状态才能被启动，如果处于非关闭状态，则返回错误信息。
	 * 注解 启动路由器之后，路由器将开始收费。
	 */
	public static final String PowerOnRouters		= 	"PowerOnRouters";
	/**
	 * 将一个受管私有网络连接到一台路由器。
	 * 这样受管私有网络可以被路由器管理起来， 受管私有网络里的主机也将获得 DHCP 自动分配地址的能力。
	 * 只有受管私有网络才能连接到路由器，一个受管私有网络可以且仅可以连接到一台路由器。 
	 * 受管私有网络可以连接到状态为 active 和 poweroffed 的路由器。
	 */
	public static final String JoinRouter			= 	"JoinRouter";
	/**
	 * 将一个或多个受管私有网络从一台路由器上断开。
	 */
	public static final String LeaveRouter			= 	"LeaveRouter";
	/**
	 * 修改一台路由器的配置。在修改配置之后，为了让配置生效，你可能需要执行 UpdateRouters 或者 ApplySecurityGroup 指令。
	 */
	public static final String ModifyRouterAttributes	= 	"ModifyRouterAttributes";
	/**
	 * 获取路由器的规则。
	 * 可根据路由器规则ID，路由器ID，规则类型等作为过滤条件，来获取路由器规则列表。
	 *  如果不指定任何过滤条件，默认返回你所拥有的所有路由器规则。
	 */
	public static final String DescribeRouterStatics	= 	"DescribeRouterStatics";
	/**
	 * 增加一条或多条路由器规则。
	 * 在增加路由器规则之后，你需要执行 UpdateRouters 来使规则添加生效。
	 */
	public static final String AddRouterStatics	= 	"AddRouterStatics";
	/**
	 * 删除一条或多条路由器规则。在删除路由器规则之后，你需要执行 UpdateRouters 来使规则删除生效。
	 */
	public static final String DeleteRouterStatics	= 	"DeleteRouterStatics";
	/**
	 * 获取路由器管理的私有网络列表。
	 * 可根据路由器ID，私有网络ID，等作为过滤条件，来获取私有网络列表。
	 */
	public static final String DescribeRouterVxnets	= 	"DescribeRouterVxnets";
	
	/**
	 * 获取一个或多个公网IP
	 * 可根据公网IP的ID，状态，名称，分配的主机ID作过滤条件，来获取公网IP列表。 
	 * 如果不指定任何过滤条件，默认返回你所拥有的所有公网IP。 
	 * 如果指定不存在的公网IP，或非法状态值，则会返回错误信息。
	 */
	public static final String DescribeEips	= 	"DescribeEips";
	/**
	 * 从IP池中分配一个公网IP，分配时可指定带宽、数量、IP组、名称及是否需要备案。
	 * 分配后的公网IP可跟主机或路由器绑定。
	 * 注解 无论公网IP是否与其他资源绑定，一旦分配成功，此IP的计费就会开始。
	 */
	public static final String AllocateEips	= 	"AllocateEips";
	/**
	 * 将一个或多个公网IP释放回IP池，同时相关IP的计费也会停止。
	 * 如果公网IP正与其他资源绑定，则需要先解绑，再释放， 保证被释放的IP处于“可用”（ available ）状态。
	 */
	public static final String ReleaseEips	= 	"ReleaseEips";
	/**
	 * 将一个“可用”（ available ）状态的公网IP绑定到主机， 绑定后的主机才具有访问外网的能力。
	 * 不能对已绑定公网IP的主机再次绑定，如果需要更改IP， 则要先解绑之前的IP，再绑定新的。
	 */
	public static final String AssociateEip	= 	"AssociateEip";
	/**
	 * 将一个或多个“绑定中”（ associated ）状态的公网IP解绑， 解绑后会变回“可用”（ available ）状态。
	 * 如果想将公网IP绑定到路由器，请参见 ModifyRouterAttributes
	 */
	public static final String DissociateEips	= 	"DissociateEips";
	/**
	 * 动态改变一个或多个公网IP的带宽，改变后计费系统会同步更新。
	 * 无论公网IP当前处于“可用”（ available ）还是“绑定中” （ associated ）状态，都可以随时改变带宽，并实时生效。
	 */
	public static final String ChangeEipsBandwidth	= 	"ChangeEipsBandwidth";
	/**
	 * 修改一个公网IP的名称和描述。
	 * 修改时不受公网IP状态限制。
	 * 一次只能修改一个公网IP。
	 */
	public static final String ModifyEipAttributes	= 	"ModifyEipAttributes";
	
	/**
	 * 获取一个或多个防火墙信息。
	 * 可根据防火墙ID，名称作过滤条件，来获取防火墙列表。
	 *  如果不指定任何过滤条件，默认返回你所拥有的所有防火墙。
	 *   如果指定不存在的防火墙ID，或非法状态值，则会返回错误信息。
	 */
	public static final String DescribeSecurityGroups	= 	"DescribeSecurityGroups";
	/**
	 * 创建防火墙。防火墙可用于保障主机和路由器的网络安全。
	 * 刚创建的防火墙不包含任何规则，即任何端口都是封闭的， 需要建立规则以打开相应的端口。
	 * 青云为每个用户提供了一个缺省防火墙，为了方便用户使用， 缺省防火墙默认打开了下行 icmp 协议和 tcp 22 端口。
	 */
	public static final String CreateSecurityGroup	= 	"CreateSecurityGroup";
	/**
	 * 删除一个或多个防火墙。
	 * 防火墙须在没有资源（主机或路由器）使用的情况下才能被删除。 
	 * 已加载规则到资源的防火墙，需先将相关资源从防火墙移出后才能被删除。
	 * 要删除的防火墙已加载规则到主机，则需要先调用 ApplySecurityGroup 将其他防火墙的规则应用到对应主机，之后才能被删除。
	 * 要删除的防火墙已加载规则到路由器，则需要先调用 ModifyRouterAttributes 并 UpdateRouters 
	 * 将其他防火墙的规则应用到对应路由器，之后才能被删除。
	 * 青云系统提供的缺省防火墙不能被删除。
	 */
	public static final String DeleteSecurityGroups	= 	"DeleteSecurityGroups";
	/**
	 * 应用防火墙规则。当防火墙的规则发生改变后，新规则不会即刻生效 （可通过 is_applied 属性分辨），需要调用 ApplySecurityGroup 之后才生效。
	 * 防火墙规则可通过 AddSecurityGroupRules, DeleteSecurityGroupRules, ModifySecurityGroupRuleAttributes 修改。
	 * 如果请求参数中传递了 instances.n ，则表示将此防火墙的规则应用到对应的主机。
	 *  如果不传此参数，则会将最新规则更新到所有已应用此防火墙的主机。
	 *  目前，主机在创建时不能指定防火墙，都是加载青云提供的缺省防火墙。 
	 *  所以若要使用自己创建的防火墙，需要调用本 API 。
	 */
	public static final String ApplySecurityGroup	= 	"ApplySecurityGroup";
	/**
	 * 修改防火墙的名称和描述。
	 * 一次只能修改一个防火墙。
	 */
	public static final String ModifySecurityGroupAttributes	= 	"ModifySecurityGroupAttributes";
	/**
	 * 获取某个防火墙的规则信息。
	 * 可根据防火墙ID，上行/下行，防火墙规则ID 作过滤条件，获取防火墙规则列表。
	 *  如果不指定任何过滤条件，默认返回你所拥有的所有防火墙的所有规则。
	 */
	public static final String DescribeSecurityGroupRules	= 	"DescribeSecurityGroupRules";
	/**
	 * 给防火墙添加规则。每条规则包括的属性为：<br>
	 * protocol：协议<br>
	 * priority：优先级，由高到低为 0 - 100<br>
	 * security_group_rule_name：规则名称<br>
	 * action：操作，分为 accept 接受 和 drop 拒绝<br>
	 * direction：方向，0 表示下行，1 表示上行。<br>
	 * val1：如果协议为 tcp 或 udp，此值表示起始端口。 如果协议为 icmp，此值表示 ICMP 类型。 具体类型可参见 ICMP 类型及代码<br>
	 * val2：如果协议为 tcp 或 udp，此值表示结束端口。 如果协议为 icmp，此值表示 ICMP 代码。 具体代码可参见 ICMP 类型及代码<br>
	 * val3：源IP<br>
	 * 注解 添加规则后，记得调用 ApplySecurityGroup 使其生效。<br>
	 */
	public static final String AddSecurityGroupRules	= 	"AddSecurityGroupRules";
	/**
	 * 删除防火墙规则。
	 * 注解 删除规则后，记得调用 ApplySecurityGroup 使其生效。
	 */
	public static final String DeleteSecurityGroupRules	= 	"DeleteSecurityGroupRules";
	/**
	 * 修改防火墙规则的优先级。
	 * 注解 修改规则后，记得调用 ApplySecurityGroup 使其生效。
	 */
	public static final String ModifySecurityGroupRuleAttributes	= 	"ModifySecurityGroupRuleAttributes";
	
	/**
	 * 获取一个或多个 SSH 密钥
	 * 可根据密钥ID，密钥名称，主机ID，加密方式作为过滤条件，获取密钥列表。 
	 * 如果不指定任何过滤条件，默认返回你所拥有的所有密钥。 
	 * 如果指定不支持的加密方式，则会返回错误信息。
	 */
	public static final String DescribeKeyPairs	= 	"DescribeKeyPairs";
	/**
	 * 创建 SSH 密钥对，每对密钥都可加载到任意多台主机中。
	 * 支持以下两种加密算法：
	 * 1024-位 DSS
	 * 2048-位 RSA （默认）
	 * 创建密钥对成功后，请及时从 API 返回结果中保存私钥， 因为我们不会保存用户的私钥数据。 
	 * 公钥数据可以随时通过 DescribeKeyPairs 得到。
	 * 另外用户也可以通过已有公钥来创建 SSH 密钥。
	 */
	public static final String CreateKeyPair	= 	"CreateKeyPair";
	/**
	 * 删除一个或多个你拥有的密钥对。
	 * 密钥对须在未使用的情况下才能被删除， 已加载到主机的密钥对需先卸载后才能删除， 关于卸载密钥对可参考 DetachKeyPairs
	 */
	public static final String DeleteKeyPairs	= 	"DeleteKeyPairs";
	/**
	 * 将任意数量密钥对加载到任意数量的主机， 主机状态须为“运行中”（ running ）或“已关机”（ stopped ）。
	 */
	public static final String AttachKeyPairs	= 	"AttachKeyPairs";
	/**
	 * 将任意数量的密钥对从主机中卸载， 主机状态须为“运行中”（ running ）或“已关机”（ stopped ）。
	 */
	public static final String DetachKeyPairs	= 	"DetachKeyPairs";
	/**
	 * 修改密钥对的名称和描述。
	 * 一次只能修改一个密钥对。
	 */
	public static final String ModifyKeyPairAttributes	= 	"ModifyKeyPairAttributes";
	/**
	 * 获取一个或多个映像
	 * 可根据映像ID，状态，映像名称、操作系统平台作过滤条件，来获取映像列表。 
	 * 如果不指定任何过滤条件，默认返回你所拥有的所有映像。 
	 * 如果指定不存在的映像ID，或非法状态值，则会返回错误信息。
	 */
	public static final String DescribeImages			= 	"DescribeImages";
	/**
	 * 将某个已关闭的主机制作成模板（或称“自有映像”），之后便可将其用于创建新的主机。 
	 * 被捕获的主机必须是已关闭（ stopped ）状态，否则会返回错误。
	 * 由主机制成的自有映像，会保留主机中安装的软件、配置及数据， 因此基于这个自有映像创建的主机，就直接获得了相同的系统环境。
	 */
	public static final String CaptureInstance			= 	"CaptureInstance";
	/**
	 * 删除一个或多个自有映像。映像须在可用（ available ） 状态下才能被删除。
	 */
	public static final String DeleteImages				= 	"DeleteImages";
	/**
	 * 修改映像的名称和描述。
	 * 修改时不受映像状态限制。
	 * 一次只能修改一个映像。
	 */
	public static final String ModifyImageAttributes	= 	"ModifyImageAttributes";
	
}
